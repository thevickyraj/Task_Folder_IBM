const mongoose = require("mongoose");

mongoose.connect("mongodb://127.0.0.1:27017/task-app")

    .then(() => {
        console.log("Connected to MongoDB");
    })
    .catch((error) => {
        console.error("MongoDB connection failed:", error);
    });