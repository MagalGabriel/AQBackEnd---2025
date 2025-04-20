package com.project.aqconvert.repository

import com.project.aqconvert.model.PassRecover
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PassRecoverRepository : JpaRepository<PassRecover, Long> {
}