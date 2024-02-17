package common.decompose_mvi.logic_layer.home.actual_stories_menu.store

import com.arkivanov.mvikotlin.core.store.Store

public interface ActualStoriesMenuStore : Store<> {

    public sealed class IntentActualStoriesMenu {
        public data class UpdataPokemonFavoriteState(val isFovorite: Boolean) :
            IntentActualStoriesMenu()
    }

    public data class StateActualStore(
        val isLoading: Boolean = false,
        val error: String? = null,
        val pokemonInfo: PokemonInfo? = null
    )

}