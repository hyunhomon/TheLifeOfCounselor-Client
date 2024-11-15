package com.example.thelifeofcounselor_client.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thelifeofcounselor_client.Router
import com.example.thelifeofcounselor_client.data.PreferencesManager
import com.example.thelifeofcounselor_client.ui.component.ActionButton
import com.example.thelifeofcounselor_client.ui.component.InputField
import com.example.thelifeofcounselor_client.ui.component.PageDescription
import com.example.thelifeofcounselor_client.ui.component.Spacing
import com.example.thelifeofcounselor_client.ui.viewmodel.StartViewModel

@Composable
fun StartScreen(
    navController: NavController,
    preferencesManager: PreferencesManager,
    viewModel: StartViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value

    BackHandler {
        if (uiState.page != 0) {
            viewModel.updatePage(0)
            viewModel.updatePw("")
            viewModel.updatePwCheck("")
            viewModel.updateShowErrorMessage(true)
        }
    }

    Column(Modifier.padding(16.dp)) {
        HeaderArea(
            page = uiState.page,
            id = uiState.id,
            onClickBack = {
                viewModel.updatePage(0)
                viewModel.updatePw("")
                viewModel.updatePwCheck("")
                viewModel.updateShowErrorMessage(true)
            }
        )
        InputArea(
            page = uiState.page,
            id = uiState.id,
            pw = uiState.pw,
            pwCheck = uiState.pwCheck,
            onIdValueChange = {
                viewModel.updateId(it)
            },
            onPwValueChange = {
                viewModel.updatePw(it)
                viewModel.updateShowErrorMessage(false)
            },
            onPwCheckValueChange = {
                viewModel.updatePwCheck(it)
                viewModel.updateShowErrorMessage(false)
            }
        )
        Spacing(vertical = 8)
        if (uiState.showErrorMessage) {
            Text(
                text = if (uiState.page == 0) "입력한 아이디가 존재하지 않으면 회원가입이 진행됩니다" else "비밀번호가 일치하지 않습니다",
                style = MaterialTheme.typography.bodySmall,
                color = if (uiState.page == 0) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
            )
        }
        Spacing(Modifier.weight(1f))
        ActionButton(
            text = when (uiState.page) {
                1 -> "로그인"
                2 -> "회원가입"
                else -> "다음으로"
            },
            onClick = {
                when (uiState.page) {
                    1 -> {
                        if (viewModel.checkPw())
                            navController.navigate(Router.DiaryScreen) { popUpTo(navController.graph.id) { inclusive = true } }
                        else
                            viewModel.updateShowErrorMessage(true)
                    }
                    2 -> {
                        if (uiState.pw == uiState.pwCheck) {
                            viewModel.createUser()
                            navController.navigate(Router.DiaryScreen) { popUpTo(navController.graph.id) { inclusive = true } }
                        } else {
                            viewModel.updateShowErrorMessage(true)
                        }
                    }
                    else -> {
                        if (viewModel.checkId())
                            viewModel.updatePage(1)
                        else
                            viewModel.updatePage(2)
                        viewModel.updateShowErrorMessage(false)
                    }
                }
            },
            isActivate = when (uiState.page) {
                0 -> uiState.id.isNotEmpty()
                else -> uiState.pw.isNotEmpty()
            }
        )
    }
}

@Composable
fun HeaderArea(
    page: Int,
    id: String,
    onClickBack: () -> Unit
) {
    when (page) {
        0 -> PageDescription(
            title = "심리상담사가 되어보세요!",
            description = "의뢰인과 대화를 진행하며\n그들의 문제를 해결해주세요!"
        )
        1 -> PageDescription(
            onClickBack = onClickBack,
            title = "비밀번호를 입력해주세요!",
            description = "${id} 계정에 로그인하세요"
        )
        2 -> PageDescription(
            onClickBack = onClickBack,
            title = "비밀번호를 입력해주세요!",
            description = "${id} 아이디로 계정을 생성하세요"
        )
    }
}

@Composable
fun InputArea(
    page: Int,
    id: String,
    pw: String,
    pwCheck: String,
    onIdValueChange: (String) -> Unit,
    onPwValueChange: (String) -> Unit,
    onPwCheckValueChange: (String) -> Unit
) {
    if (page == 0) {
        InputField(
            placeholder = "아이디를 입력해주세요",
            value = id,
            onValueChange = onIdValueChange,
            isPasswordActivate = false
        )
    } else {
        InputField(
            placeholder = "비밀번호를 입력해주세요",
            value = pw,
            onValueChange = onPwValueChange,
            isPasswordActivate = true
        )
    }
    if (page == 2) {
        Spacing(vertical = 20)
        InputField(
            placeholder = "비밀번호를 확인해주세요",
            value = pwCheck,
            onValueChange = onPwCheckValueChange,
            isPasswordActivate = true
        )
    }
}