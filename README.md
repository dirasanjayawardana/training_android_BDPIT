### flow
BuatItemLayout --> Buat RecyclerViewLayout atau GridViewLayout --> panggil di FragmentLayout atau ActivityLayout --> buat Adapter --> buat Model

// JSON dalam bentuk object
{
"user_name": "dira",
"user_address": "jakarta",
"user_email": "dira@email.com",
"user_academic": {
"user_university": "unila"
}
}

data class User(
@Serializable("user_name")
val username: String
)

// JSON dalam bentuk List of object
{
"username": [
{
"id": "1",
"name": "dira"
},
{
"id": "1",
"name": "dira"
},
{
"id": "1",
"name": "dira"
}
]
}

data class UserProfile(
@Serialize("username")
val userName: List<UserData>
)

data class UserData(
@Serialize("id")
val useId: String,

@Serialize("name")
val username: String
)