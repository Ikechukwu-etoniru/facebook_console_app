abstract class User {
    fun addFriend () {
        println("Enter friend name")
        val friendName = readln().lowercase()
        val friend = userDb.firstOrNull{it.userName == friendName}
        if (friend == null) {
            println("A user with the name $friendName doesn't exist")
            addFriend()
        } else {
            println("$friendName has been added as a friend")
            val currentUser = userDb.first { it.userName == loggedInUserName}
            when (currentUser.accountType) {
                "child account" -> openChildAccount(user = currentUser)
                "admin account" -> openAdminAccount(user = currentUser)
                else -> openAdultAccount(user = currentUser)
            }
        }
    }
    fun readPost () {
        println("Enter id of post you want to read")
        val postId = readln().lowercase()
        val post = postList.firstOrNull{ it.postId == postId}
if (post == null) {
    println("No post withe the id $postId was found")
    readPost()
}else {
    println("""
            ${post.postTitle}
            ${post.postContent}
        """)
    val currentUser = userDb.first { it.userName == loggedInUserName}
    when (currentUser.accountType) {
        "child account" -> openChildAccount(user = currentUser)
        "admin account" -> openAdminAccount(user = currentUser)
        else -> openAdultAccount(user = currentUser)
    }
}


    }
    abstract fun createPost ()
    abstract fun editPost()


    fun deletePost () {
        println("Enter id of post you want to delete")
        val postId = readln().lowercase()
        val post = postList.firstOrNull{ it.postId == postId}
        if(post == null) {
            println("No post withe the id $postId was found")
            deletePost()
        }else {
            postList.remove(post)
            println("The post ith the id $postId has been deleted")
            val currentUser = userDb.first { it.userName == loggedInUserName}
            when (currentUser.accountType) {
                "child account" -> openChildAccount(user = currentUser)
                "admin account" -> openAdminAccount(user = currentUser)
                else -> openAdultAccount(user = currentUser)
            }
        }

    }
}