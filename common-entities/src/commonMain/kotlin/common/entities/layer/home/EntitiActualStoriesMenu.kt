package common.entities.layer.home

import kotlinx.serialization.Serializable

@Serializable
data class EntitiActualStoriesMenu(
    val id: Int,
    val urlImage: String,
    val title: String,
){}
