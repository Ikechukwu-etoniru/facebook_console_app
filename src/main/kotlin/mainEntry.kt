
var userDb = mutableListOf<UserClass>()
var guardianUserDb = mutableListOf<UserClass>()

var postList = mutableListOf<UserPost>()
var childPostAwaitingApproval = mutableListOf<UserPost>()

var loggedInUserName = ""

fun main () {
    if (checkAuth()) {
        login()
    } else {
        signUp()
    }
}

private fun  checkAuth () : Boolean {
    println("Do you want to Login or Signup")
    var userStatus = readln().lowercase()
    while (userStatus != "login" && userStatus != "signup"){
        println("Enter either login or signup")
        userStatus = readln().lowercase()
        if (userStatus == "login" || userStatus == "signup"){
            break
        }
    }
    return userStatus == "login"

}

private fun login ()  {
    println("Enter your username")
    val nameController = readln()
    println("Enter your password")
    val passwordController = readln()
    val currentUser = userDb.firstOrNull{ it.userName == nameController && it.userPassword == passwordController}

    if (currentUser == null)  {
    println("User with this details doesn't exist")
    login()
} else if (currentUser.accountType == "child account") {
    println("Login successful")
        loggedInUserName = currentUser.name
    openChildAccount(user = currentUser)
}else if (currentUser.accountType == "admin account") {
    println("Login successful")
        loggedInUserName = currentUser.name
    openAdminAccount(user = currentUser)
} else {
    println("Login successful")
        loggedInUserName = currentUser.name
    openAdultAccount(user = currentUser)
}
}
private fun signUp () {
    println("Welcome to Facebook Console")
    println("Are you an admin? Enter Yes or No")
    var adminStatusController = readln()

    while (adminStatusController != "yes" && adminStatusController != "no") {
        println("Are you an admin? Enter either Yes or No")
        adminStatusController = readln()
        if (adminStatusController == "yes" || adminStatusController == "no"){
            break
        }
    }
    val adminStatus : Boolean = adminStatusController == "yes"
    println("Choose a username")
    val nameController = readln()
    println("Enter your password")
    val passwordController = readln()
    println("Confirm your password")
    var confirmPasswordController = readln()
    while (confirmPasswordController != passwordController) {
        println("Passwords do not match, enter previous password")
        confirmPasswordController = readln()
        if (confirmPasswordController == passwordController) {
            break
        }
    }
    println("Enter your age")
    var age = readln().toIntOrNull()
    while (age == null || age > 100) {
        println("Enter a valid age")
         age = readln().toIntOrNull()
        if (age !=null){
            break
        }
    }
    val accountStatus = if (age!! <= 13) "child account" else if(adminStatus) "admin account" else "adult account"
    val newUser = UserClass(name = nameController, age = age, password = passwordController, adminStatus = adminStatus, accountStatus = accountStatus)
    userDb.add(newUser)
    println("Registration successful, You can now login")
    login()
}

fun logOut () {
    loggedInUserName = ""
    println("Logout Successful")
    checkAuth()
}