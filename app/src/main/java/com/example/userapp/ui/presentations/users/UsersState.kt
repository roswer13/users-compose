package com.example.userapp.ui.presentations.users

import com.example.userapp.model.Response

/**
 * Sealed interface for representing the state of the Users.
 * It has three possible states: Success, Error, and Loading.
 */
sealed interface UsersState {
    /**
     * Represents the Success state of the Users.
     * It contains a string of users.
     * @property users The response object of users.
     */
    data class Success(val users: Response) : UsersState

    /**
     * Represents the Error state of the Users.
     * It is an object as it does not contain any properties.
     */
    object Error : UsersState

    /**
     * Represents the Loading state of the Users.
     * It is an object as it does not contain any properties.
     */
    object Loading : UsersState
}