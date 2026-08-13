// Import mongoose
const mongoose = require("mongoose");


// Connect to MongoDB
mongoose.connect("mongodb://127.0.0.1:27017/nodejsdb")
    .then(() => {
        console.log("Connected to MongoDB");
    })
    .catch((error) => {
        console.error("MongoDB connection error:", error);
    });


// Define the user schema
const userSchema = new mongoose.Schema({

    name: String,

    age: Number,

    email: {
        type: String,
        required: true
    }

});


// Create the User model
const User = mongoose.model("User", userSchema);


// Create a new user/document
const newUser = new User({
    name: "Vicky",
    age: 23,
    email: "vicky@example.com"
});


// Save the document into MongoDB
newUser.save()
    .then(() => {
        console.log("User saved successfully!");
    })
    .catch((error) => {
        console.error("Error saving user:", error);
    });