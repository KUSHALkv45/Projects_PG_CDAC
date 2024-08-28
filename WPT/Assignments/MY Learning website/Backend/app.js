import express from 'express';
import mongoose from 'mongoose';
import dotenv from 'dotenv';

// dotenv.config();

// const app = express();
// const port = 5000;

// const username = 'venkatakushal1';
// const password = process.env.MONGODB_PASSWORD;
// const cluster = 'cluster1.eufrxtg.mongodb.net';
// const database = 'myDatabase'; // Replace with your actual database name

// const uri = `mongodb+srv://${username}:${password}@${cluster}/${database}?retryWrites=true&w=majority`;

// mongoose.connect(uri)
//   .then(() => {
//     console.log("Connected to database");
//     app.listen(port, () => console.log(`Server is running on port ${port}`));
//   })
//   .catch((e) => console.log("Error connecting to the database:", e));

// app.get("/", (req, res) => {
//   res.send("<h1> HI </h1>");
// });



const { MongoClient, ServerApiVersion } = require('mongodb');
const uri = "mongodb+srv://venkatakushal1:MongoDB@mirai@1@cluster1.eufrxtg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster1";

// Create a MongoClient with a MongoClientOptions object to set the Stable API version
const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  }
});

async function run() {
  try {
    // Connect the client to the server	(optional starting in v4.7)
    await client.connect();
    // Send a ping to confirm a successful connection
    await client.db("admin").command({ ping: 1 });
    console.log("Pinged your deployment. You successfully connected to MongoDB!");
  } finally {
    // Ensures that the client will close when you finish/error
    await client.close();
  }
}
run().catch(console.dir);
