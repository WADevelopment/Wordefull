package com.gamovation.feature.level.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gamovation.core.domain.level.LevelScreenState
import com.gamovation.core.ui.Dimensions
import com.gamovation.feature.level.domain.model.LevelUiDetails
import com.gamovation.feature.level.level1.Level1Content
import com.gamovation.feature.level.level10.Level10Content
import com.gamovation.feature.level.level11.Level11Content
import com.gamovation.feature.level.level12.Level12Content
import com.gamovation.feature.level.level13.Level13Content
import com.gamovation.feature.level.level14.Level14Content
import com.gamovation.feature.level.level15.Level15Content
import com.gamovation.feature.level.level16.Level16Content
import com.gamovation.feature.level.level17.Level17Content
import com.gamovation.feature.level.level18.Level18Content
import com.gamovation.feature.level.level19.Level19Content
import com.gamovation.feature.level.level2.Level2Content
import com.gamovation.feature.level.level20.Level20Content
import com.gamovation.feature.level.level3.Level3Content
import com.gamovation.feature.level.level4.Level4Content
import com.gamovation.feature.level.level5.Level5Content
import com.gamovation.feature.level.level6.Level6Content
import com.gamovation.feature.level.level7.Level7Content
import com.gamovation.feature.level.level8.Level8Content
import com.gamovation.feature.level.level9.Level9Content

@Composable
internal fun LevelBody(
    details: LevelUiDetails,
    onLevelScreenAction: (LevelScreenState) -> Unit,
    onReviewRequest: () -> Unit
) {
    val title = stringResource(id = details.title)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (title.isNotBlank()) {
            Title(text = title)
            Spacer(modifier = Modifier.height(Dimensions.Padding.Small.value))
        }

        when (details.id) {
            1 -> Level1Content(
                onLevelAction = onLevelScreenAction
            )

            2 -> Level2Content(
                onLevelAction = onLevelScreenAction
            )

            3 -> Level3Content(
                onLevelAction = onLevelScreenAction,
                onReviewRequest = onReviewRequest
            )

            4 -> Level4Content(
                onLevelAction = onLevelScreenAction
            )

            5 -> Level5Content(
                onLevelAction = onLevelScreenAction
            )

            6 -> Level6Content(
                onLevelAction = onLevelScreenAction
            )

            7 -> Level7Content(
                onLevelAction = onLevelScreenAction
            )

            8 -> Level8Content(
                onLevelAction = onLevelScreenAction
            )

            9 -> Level9Content(
                onLevelAction = onLevelScreenAction
            )

            10 -> Level10Content(
                onLevelAction = onLevelScreenAction
            )

            11 -> Level11Content(
                onLevelAction = onLevelScreenAction
            )

            12 -> Level12Content(
                onLevelAction = onLevelScreenAction
            )

            13 -> Level13Content(
                onLevelAction = onLevelScreenAction
            )

            14 -> Level14Content(
                onLevelAction = onLevelScreenAction
            )

            15 -> Level15Content(
                onLevelAction = onLevelScreenAction
            )

            16 -> Level16Content(
                onLevelAction = onLevelScreenAction
            )

            17 -> Level17Content(
                onLevelAction = onLevelScreenAction
            )

            18 -> Level18Content(
                onLevelAction = onLevelScreenAction
            )

            19 -> Level19Content(
                onLevelAction = onLevelScreenAction
            )

            20 -> Level20Content(
                onLevelAction = onLevelScreenAction
            )

            else -> {}
        }
    }
}
