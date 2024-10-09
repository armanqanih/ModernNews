package org.lotka.xenon.presentation.screen.my_card

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.lotka.xenon.domain.usecase.GetCartItemsUseCase
import org.lotka.xenon.domain.usecase.RemoveItemFromCartUseCase
import org.lotka.xenon.presentation.util.UiEvent
import javax.inject.Inject

@HiltViewModel
class MyCardViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val removeItemFromCartUseCase: RemoveItemFromCartUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(MyCardState())
    val state = _state.asStateFlow()


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getCardItem()
    }

    fun getCardItem() {
        viewModelScope.launch {
            getCartItemsUseCase.invoke().collect { itemsList ->
                Log.d("MyCardViewModel", "Fetched items: $itemsList") // Debug log
                _state.value = _state.value.copy(
                    items = itemsList
                )
            }
        }
    }


    fun removeItemInCard(itemId:String){
        viewModelScope.launch {
        removeItemFromCartUseCase.invoke(itemId)
        }
    }


}