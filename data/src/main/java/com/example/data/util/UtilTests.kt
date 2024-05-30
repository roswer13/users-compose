package com.example.data.util

import com.example.domain.model.ResponseData
import com.example.domain.model.Support
import com.example.domain.model.User

object UtilTests {
    private val dummyUsers = listOf(
        User(1, "test@test.com", "John", "Doe", "https://i.pravatar.cc/300"),
        User(2, "test2@test.com", "Jane", "Doe", "https://i.pravatar.cc/300")
    )
    private val dummySupport = Support(
        "https://reqres.in/#support-url", "https://reqres.in/#support-heading"
    )
    val dummyResponseData = ResponseData(
        page = 1, perPage = 2, total = 2, totalPages = 2, data = dummyUsers, support = dummySupport
    )
}