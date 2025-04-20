package com.project.aqconvert.repository

import com.project.aqconvert.model.Calendar
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CalendarRepository : JpaRepository<Calendar, Long> {
}