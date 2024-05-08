package com.example.ibustartup.backend.events

import com.example.ibustartup.backend.tables.User

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class SetFirstName(val firstName: String): UserEvent
    data class SetLastName(val lastName: String): UserEvent
    data class SetEmail(val email: String): UserEvent
    data class SetPassword(val password: String): UserEvent
    data class DeleteUser(val user: User): UserEvent
}
