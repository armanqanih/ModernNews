package org.lotka.xenon.domain.usecase.explorer

import kotlinx.coroutines.flow.Flow
import org.lotka.xenon.domain.model.Category
import org.lotka.xenon.domain.repository.ExploreRepository
import org.lotka.xenon.domain.util.Resource
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val exploreRepository: ExploreRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> {
        return exploreRepository.getCategories()
    }
}


