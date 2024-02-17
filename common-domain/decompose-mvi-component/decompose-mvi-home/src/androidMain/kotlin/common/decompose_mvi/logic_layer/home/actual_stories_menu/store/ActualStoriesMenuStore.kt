package common.decompose_mvi.logic_layer.home.actual_stories_menu.store

import com.arkivanov.mvikotlin.core.store.Store

interface ActualStoriesMenuStore : Store<> {

    sealed class IntentActualStoriesMenu {
        data class UpdataPokemonFavoriteState(val isFovorite: Boolean): IntentActualStoriesMenu
    }

    data class StateActualStore(
        val isLoading: Boolean = false,
        val error: String? = null,
        val pokemonInfo: PokemonInfo? = null
    )

}