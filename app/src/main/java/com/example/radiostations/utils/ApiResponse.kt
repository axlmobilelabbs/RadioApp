package com.example.radiostations.utils

import com.example.radiostations.model.BaseModel
import io.reactivex.annotations.NonNull

class ApiResponse private constructor(
    val status: Status,
    val data: BaseModel?,
    val error: Throwable?
) {
    companion object {

        fun loading(): ApiResponse {
            return ApiResponse(Status.LOADING, null, null)
        }

        fun success(@NonNull data: BaseModel): ApiResponse {
            return ApiResponse(Status.SUCCESS, data, null)
        }

        fun error(@NonNull error: Throwable): ApiResponse {
            return ApiResponse(Status.ERROR, null, error)
        }
    }

}
