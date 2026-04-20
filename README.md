# 🤖 AI Helpdesk Chat System

An intelligent AI-powered helpdesk assistant that helps users resolve issues in real-time. If the AI cannot fully resolve the problem, it seamlessly escalates the issue by creating a support ticket and notifying the support team.

---

## 🚀 Features

### 🧠 AI Assistance
- Conversational AI chatbot powered by Spring AI
- Guides users step-by-step to resolve their issues
- Context-aware responses using RAG (Retrieval-Augmented Generation)

### 💬 Streaming Responses
- Real-time streaming responses for a smooth chat experience
- Mimics natural conversation flow

### 🧩 Chat Memory & Sessions
- Maintains user session context
- Remembers previous messages for better continuity

### 🎫 Ticket Creation System
- Automatically creates a support ticket if the issue is unresolved
- Sends the ticket to the support staff/system
- Ensures no user query is left unanswered

### 🔍 RAG Integration
- Fetches relevant knowledge base data
- Enhances response accuracy using external context

---

## 🏗️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring AI
- Features used:
  - Streaming responses
  - RAG (Retrieval-Augmented Generation)
  - Chat memory
  - User session management

### Frontend
- React.js
- Tailwind CSS
- shadcn/ui
- React Router
- Lucide React (icons)

---

## ⚙️ How It Works

1. User starts a chat with the AI assistant  
2. AI processes the query using:
   - Chat history (memory)
   - Knowledge base (RAG)  
3. AI responds in real-time (streaming)  
4. If unresolved:
   - AI triggers ticket creation  
   - Ticket is forwarded to support staff  

---

## 🧪 Setup Instructions

### 🔧 Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run

Configure your AI provider API key (e.g., OpenAI/Gemini) in application.properties.

Frontend(React)
cd frontend
npm install
npm run dev

🔐 Environment Variables
SPRING_AI_API_KEY=your_api_key_here
SPRING_AI_MODEL=your_model_name

