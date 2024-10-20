package org.lotka.xenon.domain.usecase.detail

import kotlinx.coroutines.flow.Flow
import org.lotka.xenon.domain.model.Item
import org.lotka.xenon.domain.repository.ExploreRepository
import org.lotka.xenon.domain.util.Resource
import javax.inject.Inject

class GetDetailItemUseCase @Inject constructor(
    private val repository: ExploreRepository
) {
    operator fun invoke(itemId: String): Flow<Resource<Item>> {
        return repository.getDetailItem(itemId)
    }
}
