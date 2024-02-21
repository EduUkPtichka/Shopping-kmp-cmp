package common.data.remote.home.actual_stories.repositories

import common.entities.layer.home.EntitiActualStoriesMenu

public interface RepoApiActualStories {

    public suspend fun getListItemActualStoriesMenu(): List<EntitiActualStoriesMenu>
}
