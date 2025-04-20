package com.project.aqconvert.repository

import com.project.aqconvert.model.News
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : JpaRepository<News, Long> {
}