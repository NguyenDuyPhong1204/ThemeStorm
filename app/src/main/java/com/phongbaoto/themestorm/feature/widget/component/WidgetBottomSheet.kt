package com.phongbaoto.themestorm.feature.widget.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.phongbaoto.themestorm.core.model.ItemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WidgetBottomSheet(
    item: ItemTheme,
    isShowSheet: Boolean = false,
    onDismiss: () -> Unit,
    onClose: () -> Unit,
    onClickInfo: () -> Unit,
    onClickFavorite: () -> Unit,
    onDownload: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    if (isShowSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            dragHandle = null,
            contentWindowInsets = {
                WindowInsets(0, 0, 0, 0)
            }
        ) {
            WidgetBottomSheetLayout(
                item = item,
                onClose = onClose,
                onClickInfo = onClickInfo,
                onClickFavorite = onClickFavorite,
                onDownload = onDownload
            )
        }
    }
}
