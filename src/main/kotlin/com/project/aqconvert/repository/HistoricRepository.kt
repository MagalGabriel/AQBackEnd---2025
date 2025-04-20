package com.project.aqconvert.repository

import com.project.aqconvert.model.Historic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoricRepository : JpaRepository<Historic, Long> {
}