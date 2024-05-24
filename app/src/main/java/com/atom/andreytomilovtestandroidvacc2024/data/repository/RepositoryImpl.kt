package com.atom.andreytomilovtestandroidvacc2024.data.repository

import com.atom.andreytomilovtestandroidvacc2024.data.network.ApiService
import com.atom.andreytomilovtestandroidvacc2024.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
}