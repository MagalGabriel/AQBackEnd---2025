import { QuestionInterface } from "../Interfaces/Question";
import { SubjectInterface } from "../Interfaces/Subject";
import { Question } from "../Models/Question";
import { Subject } from "../Models/Subject";
import { Topic } from "../Models/Topic";

export async function GenerateTest(
    subject: string, topic: string, questionCount: number
): Promise<QuestionInterface[] | null> {

    let questions: QuestionInterface[] = []
    if (subject == "Nenhuma" && topic == "Nenhum") {
        //gerar padrão
        questions = await Question.find()

    }
    else if (topic == "Nenhum") {

        const subjectTopics: (SubjectInterface & {
            topics: {
                questions: QuestionInterface[]
            }[]
        }) | null = await Subject
            .findOne({ nome: subject })
            .select({ nome: 1 })
            .populate({
                path: 'topics', select: 'questions topic',
                populate: { path: 'questions', model: 'Question' }
            })
        // console.log(subjectTopics)
        if (!subjectTopics)
            return null

        subjectTopics.topics.forEach(topic => {
            questions = questions.concat(topic.questions)
        })
    }
    else {
        const topicsQuestions = await Topic.findOne({ nome: topic }).populate('questions')

        if (topicsQuestions)
            questions = topicsQuestions?.questions as QuestionInterface[]
    }

    if (questions.length != 0)
        return RandomQuestions((questions as QuestionInterface[]), questionCount)
    else
        return null

}

//criar uma função para auxiliar na aleatorização

function RandomQuestions(questions: QuestionInterface[], total: number) {
    if (!questions)
        return null

    // Copia o array original para não afetar o original
    const shuffled = [...questions]

    // Algoritmo de Fisher-Yates para embaralhar
    for (let i = shuffled.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1))
        const temp = shuffled[i]
        shuffled[i] = shuffled[j]
        shuffled[j] = temp
    }

    // Retorna no máximo o total pedido, ou todo o array se tiver menos
    return shuffled.slice(0, total)
}