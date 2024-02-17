package common.data.remote.home.actual_stories.repositories

import common.entities.layer.home.EntitiActualStoriesMenu

interface RepoApiActualStories {

    suspend fun getListItemActualStories(): List<EntitiActualStoriesMenu>
}
