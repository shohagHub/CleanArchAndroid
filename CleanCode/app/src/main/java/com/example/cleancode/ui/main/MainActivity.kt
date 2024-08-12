package com.example.cleancode.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleancode.data.datasource.UserRemoteDataSourceImpl
import com.example.cleancode.data.repository.UserRepositoryImpl
import com.example.cleancode.domain.usecase.GetUsersUseCase
import com.example.cleancode.ui.theme.CleanCodeTheme
import com.example.cleancode.ui.viewmodel.UserViewModel
import com.example.cleancode.ui.viewmodel.UserViewModelFactory
import androidx.compose.foundation.lazy.items
import androidx.room.Room
import com.example.cleancode.data.datasource.UserDatabase

class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels {
        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user_database"
        ).build()

        UserViewModelFactory(GetUsersUseCase(UserRepositoryImpl(database.userDao())))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanCodeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                Surface(color = MaterialTheme.colorScheme.background) {
                    UserScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanCodeTheme {
        Greeting("Android")
    }
}

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val users by viewModel.users.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    LazyColumn(modifier = Modifier.padding(50.dp, 200.dp)) {
        items(users) { user ->
            Log.e("Shohag", "UserScreen: " + user.name )
            Text(text = user.name, style = MaterialTheme.typography.bodyLarge)
        }
    }
}