package com.andraganoid.myworld.repo

import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.model.Country

class CountriesRepositoryImpl(private val  worldApi: CountriesApi):CountriesRepository {
    override fun getAllCountries(
        onSuccess: (countries: ArrayList<Country>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }


}



//class UserRepositoryImpl(private val api: Api) : UserRepository {
//
//    override fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit) {
//        api.getUser(username).enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                response.body()?.let { user ->
//                    onSuccess.invoke(user)
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                onFailure.invoke(t)
//            }
//        })
//    }
//}