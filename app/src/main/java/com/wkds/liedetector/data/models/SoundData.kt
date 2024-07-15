package com.wkds.liedetector.data.models

import com.wkds.liedetector.R
import kotlinx.serialization.Serializable

abstract class SoundData {
    abstract fun getSoundData(page: String): List<GridItem>
}

class ConcreteSoundData : SoundData() {
    override fun getSoundData(page: String): List<GridItem> {
        return when (page) {
            "Animal" -> listOf(
                GridItem(
                    imageResId = R.drawable.cowsound,
                    audioResId = R.raw.cow_single_moo
                ),
                GridItem(
                    imageResId = R.drawable.cowsound1,
                    audioResId = R.raw.cow_moo_in_barn
                ),
                GridItem(
                    imageResId = R.drawable.dogsound,
                    audioResId = R.raw.medium_size_angry_dog_bark
                ),
                GridItem(
                    imageResId = R.drawable.dogsound1,
                    audioResId = R.raw.happy_puppy_barks
                )
            )

            "Baby" -> listOf(
                GridItem(
                    imageResId = R.drawable.babysound1,
                    audioResId = R.raw.boy_volcano
                ),
                GridItem(
                    imageResId = R.drawable.babysound1b,
                    audioResId = R.raw.boy_volcano
                ),
                GridItem(
                    imageResId = R.drawable.babysound2,
                    audioResId = R.raw.boy_soccer
                ),
                GridItem(
                    imageResId = R.drawable.babysound2b,
                    audioResId = R.raw.boy_soccer
                )
            )

            "Gun" -> listOf(
                GridItem(
                    imageResId = R.drawable.gunsound1,
                    audioResId = R.raw.pistol
                ),
                GridItem(
                    imageResId = R.drawable.gunsound1b,
                    audioResId = R.raw.pistol
                ),
                GridItem(
                    imageResId = R.drawable.gunsound2,
                    audioResId = R.raw.sniper
                ),
                GridItem(
                    imageResId = R.drawable.gunsound2b,
                    audioResId = R.raw.sniper
                )
            )

            else -> listOf()
        }
    }
}

@Serializable
data class GridItem(val imageResId: Int, val audioResId: Int)
