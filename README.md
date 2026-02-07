# Secure Message

## Project Overview
Secure Message is an application designed to provide users with a safe and efficient way to send and receive encrypted messages. The goal of this project is to ensure user privacy and data security.

## Setup Instructions
1. Clone the repository
   ```bash
   git clone https://github.com/Mohd-Arsal/secureMessage.git
   cd secureMessage
   ```
2. Install the required dependencies
   ```bash
   npm install
   ```
3. Create a `.env` file in the root directory and configure the necessary environment variables.

## Project Structure
```
secureMessage/
│
├── src/
│   ├── components/       # React components
│   ├── hooks/            # Custom Hooks
│   ├── utils/            # Utility functions
│   ├── styles/           # CSS styles
│   ├── App.js            # Main application file
│   └── index.js          # Entry point
│
├── public/               # Static files
│
├── .env                  # Environment variables
├── package.json           # Project metadata and dependencies
└── README.md             # Documentation
```

## Tech Stack
- React
- Node.js
- Express
- MongoDB
- JWT for authentication
- Axios for API requests

## Features
- User authentication and authorization
- End-to-end encryption for messages
- User-friendly interface
- Group messaging
- Message history retrieval

## How to Run
1. Run the backend server
   ```bash
   npm run server
   ```
2. In another terminal, run the frontend
   ```bash
   npm start
   ```
3. Navigate to `http://localhost:3000` in your browser to view the app.

## Troubleshooting
- If you encounter issues with dependencies, ensure you are using the correct version of Node.js.
- For environment variable issues, double-check the `.env` file for accuracy.

## Future Enhancements
- Implement additional encryption algorithms
- Create a mobile version of the app
- Add notifications for new messages
- Enhance UI/UX based on user feedback
