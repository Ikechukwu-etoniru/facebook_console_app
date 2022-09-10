class Child: User() {

 fun addGuardian () {
     println("Enter the username of the user you wish to add as a guardian")
     val guardianName = readln().lowercase()
     val guardianUser = userDb.firstOrNull{it.userName == guardianName}
     if (guardianUser == null) {
         println("The name you entered doesn't belong to any user")
         addGuardian()
     } else{
         guardianUserDb.add(guardianUser)
         println("Guardian added successfully")
         openChildAccount(user = userDb.first{it.userName == loggedInUserName})
     }
}

    override fun createPost() {
        println("Enter post id")
        val postId = readln().lowercase()
        println("Enter post title")
        val postTitle = readln().lowercase()
        println("Enter post content")
        val postContent = readln().lowercase()
        println("Enter ID of adult to approve post")
        val adultId = readln().lowercase()
        val thisUserPost = UserPost(id = postId, title = postTitle, content = postContent)
        childPostAwaitingApproval.add(thisUserPost)
        println("Post awaiting approval")
        openChildAccount(user = userDb.first{it.userName == loggedInUserName})
    }

    override fun editPost() {
        println("Enter post id")
        val postId = readln().lowercase()
        println("Enter new content")
        val updatedContent = readln().lowercase()
        var postToEdit = postList.firstOrNull{it.id == postId}
        if (postToEdit == null) {
            println("No post exists with the id $postId")
            editPost()
        }else {
            postToEdit.postContent = updatedContent
            postList.removeIf { it.id == postToEdit.id }
            childPostAwaitingApproval.add(postToEdit)
            println("Post has been edited")
            openChildAccount(user = userDb.first{it.userName == loggedInUserName})
        }
    }
}