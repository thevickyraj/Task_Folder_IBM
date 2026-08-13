// app.js

// Import the Express framework.
// Express is used to create the web server and define routes.
const express = require('express');

// Import body-parser.
// body-parser reads data sent from HTML forms and JSON requests.
const bodyParser = require('body-parser');

// This is an array used as a temporary database.
// All notes are stored in memory while the application is running.
//
// IMPORTANT:
// If the server is stopped/restarted, these notes will be lost.
const notes = [
    {
        noteId: 1,
        noteContent: "Hey, Prasunamba you can add your important notes here."
    }
];

// Create an Express application.
const app = express();

// Serve static files from the "public" folder (styles, images, etc.)
app.use(express.static('public'));

// Tell Express that we are using EJS as the view/template engine.
//
// When we call:
//     res.render("home")
//
// Express will look for:
//     views/home.ejs
app.set('view engine', 'ejs');

// Middleware to parse JSON request bodies.
//
// For example, if a client sends:
// { "noteContent": "Hello" }
//
// we can access it using:
// req.body.noteContent
app.use(bodyParser.json());

// Middleware to parse data submitted through HTML forms.
//
// extended: true allows parsing of richer/nested form data.
app.use(bodyParser.urlencoded({
    extended: true
}));


// ==========================================================
// GET "/" - Display all notes
// ==========================================================

// When the user visits:
// http://localhost:3000/
//
// this route is executed.
app.get("/", function (req, res) {

    // Render the home.ejs page.
    //
    // We send the notes array to the EJS template
    // using the property name "data".
    res.render("home", {
        data: notes
    });
});


// ==========================================================
// POST "/" - Add a new note
// ==========================================================

// This route is executed when the Add Note form is submitted.
app.post("/", (req, res) => {

    // Get the note content submitted from the HTML form.
    //
    // The form contains:
    // name="noteContent"
    //
    // Therefore:
    // req.body.noteContent
    // contains the entered note.
    const noteContent = req.body.noteContent;

    // Generate a new ID.
    //
    // Example:
    // If there are 2 notes, the new note gets ID 3.
    const noteId = notes.length + 1;

    // Add the new note to the notes array.
    notes.push({
        noteId: noteId,
        noteContent: noteContent
    });

    // Render the home page again with the updated notes.
    res.render("home", {
        data: notes
    });
});


// ==========================================================
// POST "/update" - Update an existing note
// ==========================================================

// This route is executed when the Update button is clicked.
app.post('/update', (req, res) => {

    // Get the note ID submitted by the form.
    var noteId = req.body.noteId;

    // Get the updated note content.
    var noteContent = req.body.noteContent;

    // Loop through every note in the notes array.
    notes.forEach(note => {

        // Find the note whose ID matches the ID
        // submitted by the user.
        if (note.noteId == noteId) {

            // Update that note's content.
            note.noteContent = noteContent;
        }
    });

    // Display the updated notes on the home page.
    res.render("home", {
        data: notes
    });
});


// ==========================================================
// POST "/delete" - Delete an existing note
// ==========================================================

app.post('/delete', (req, res) => {

    // Get the ID of the note that the user wants to delete.
    var noteId = req.body.noteId;

    // This variable keeps track of the position/index
    // of the current note in the array.
    var j = 0;

    // Loop through all notes.
    notes.forEach(note => {

        // Increase the position counter.
        j = j + 1;

        // Check whether this is the note the user wants to delete.
        if (note.noteId == noteId) {

            // Remove the note from the array.
            //
            // j - 1 is used because array indexes start from 0.
            notes.splice((j - 1), 1);
        }
    });

    // Display the remaining notes.
    res.render("home", {
        data: notes
    });
});


// ==========================================================
// Start the server
// ==========================================================

// Start the Express server on port 3000.
app.listen(3000, (req, res) => {

    // Display a message in the terminal
    // when the server starts successfully.
    console.log("App is running on port 3000");
});




