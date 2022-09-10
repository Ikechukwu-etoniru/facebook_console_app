fun openChildAccount(user: UserClass) {
    val childUser = Child()
   val userActionList = listOf("logout", "delete post", "edit post", "create post", "read post", "add friend", "add guardian")
    println(""" 
        Welcome ${user.userName}, What do you want to do today?
        Add friend | Read Post | Create Post | Edit Post | Delete Post | Add Guardian | Logout        
    """)
    var userAction = readln().lowercase()
    while (!userActionList.contains(userAction)) {
        println(""" 
        ${user.userName} select one of the action below
        Add friend | Read Post | Create Post | Edit Post* | Delete Post | Add Guardian | Logout        
    """)
        userAction = readln().lowercase()

        if (userActionList.contains(userAction)){
            break
        }
    }
    when (userAction) {
        "add friend" -> childUser.addFriend()
        "read Post" -> childUser.readPost()
        "create Post" -> childUser.createPost()
        "edit Post" -> childUser.editPost()
        "delete Post" -> childUser.deletePost()
        "add guardian" -> childUser.addGuardian()
        "logout" -> logOut()
    }

}
fun openAdminAccount(user: UserClass) {
    val adminUser = Admin()
    val userActionList = listOf("logout", "delete post", "edit post", "create post", "read post", "add friend", "flag post", "ban account")
    println(""" 
        Welcome Admin ${user.userName}, What do you want to do today?
        Add friend | Read Post | Create Post | Edit Post | Delete Post | Flag Post | Ban Account | Logout        
    """)
    var userAction = readln().lowercase()
    while (!userActionList.contains(userAction)) {
        println(""" 
        ${user.userName} select one of the action below
        Add friend | Read Post | Create Post | Edit Post | Delete Post | Flag Post | Ban Account | Logout        
    """)
        userAction = readln().lowercase()
        if (userActionList.contains(userAction)){
            break
        }
    }
    when(userAction) {
        "add friend" -> adminUser.addFriend()
        "read post" -> adminUser.readPost()
        "create post" -> adminUser.createPost()
        "edit post" -> adminUser.editPost()
        "delete post" -> adminUser.deletePost()
        "flag post" -> adminUser.flagPost()
        "ban account" -> adminUser.banAccount()
        "logout" -> logOut()
    }
}
fun openAdultAccount(user: UserClass) {
    val adultUser = Adult()
    val userActionList = listOf("logout", "delete post", "edit post", "create post", "read post", "add friend", "approve child post")
    println(""" 
        Welcome ${user.userName}, What do you want to do today?
        Add friend | Read Post | Create Post | Edit Post | Delete Post | Approve Child Post | logout        
    """)
    var userAction = readln().lowercase()
    while (!userActionList.contains(userAction)) {
        println(""" 
        ${user.userName} select one of the action below
        Add friend | Read Post | Create Post | Edit Post | Delete Post | Approve Child Post | Logout        
    """)
        userAction = readln().lowercase()
        if (userActionList.contains(userAction)){
            break
        }
    }
    when(userAction) {
        "add friend" -> adultUser.addFriend()
        "read post" -> adultUser.readPost()
        "create post" -> adultUser.createPost()
        "edit post" -> adultUser.editPost()
        "delete post" -> adultUser.deletePost()
        "approve child post" -> adultUser.approveChildPost()
        "logout" -> logOut()
    }
}