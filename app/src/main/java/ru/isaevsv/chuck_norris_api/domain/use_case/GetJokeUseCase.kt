package ru.isaevsv.chuck_norris_api.domain.use_case

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.isaevsv.chuck_norris_api.core.Resource
import ru.isaevsv.chuck_norris_api.domain.repository.ChuckRepository
import java.io.IOException
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(
    private val repository: ChuckRepository
) {
    operator fun invoke(number: String): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading())
            val jokes = repository.getJoke(count = number.toInt())
                .value.map { it.joke.replace("&quot;", "\"") }
            emit(Resource.Success(data = jokes))
        } catch (e: HttpException) {
            Log.e("Error Http", e.message.toString())
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            Log.e("error IO", e.message.toString())
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connections"))
        } catch (e: NumberFormatException) {
            Log.e("error NFE", e.message.toString())
            emit(Resource.Error(message = "You entered an invalid number format. " +
                        "\n Please enter only an integer number"))
        }
    }
}