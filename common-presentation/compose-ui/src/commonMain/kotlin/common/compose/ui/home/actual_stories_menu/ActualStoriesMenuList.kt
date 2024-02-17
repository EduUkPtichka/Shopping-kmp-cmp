package common.compose.ui.home.actual_stories_menu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ActualStoriesListContent(component: ActualStoriesComponent) {
    val model: ActualStoriesComponent.ActualStoriesComponentModel by component.models.subscribeAsState()
    ActualStoriesList(
        listItemActualStories = model
    )
}

@Composable
internal fun ActualStoriesList(
    listItemActualStories: ActualStoriesComponent.ActualStoriesComponentModel,
//    onClickActualStories: (id: String) -> Unit,
//    modifier: Modifier = Modifier,
) {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
//        modifier = modifier
    ) {
        itemsIndexed(listItemActualStories.listItems) { index, item ->
            ActualStoriesWidget(
                itemActualStories = item,
                index = index,
            )

        }
    }

}