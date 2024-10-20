package org.lotka.xenon.presentation.screen.auth.register

sealed class RegisterEvent {

     data class EnterUserName (val userName:String): RegisterEvent()
     data class EnterPassword (val password:String): RegisterEvent()
     data class EnterEmail (val email:String): RegisterEvent()
     data class ShowSnakeBar(val message:String): RegisterEvent()
     object IsPasswordVisibility : RegisterEvent()
     object Register : RegisterEvent()

}