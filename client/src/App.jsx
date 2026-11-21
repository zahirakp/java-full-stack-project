
import { Routes, Route } from "react-router-dom";


import Register from "./pages/Register";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import ProtectedRoute from "./components/ProtectedRoute";

function App() {
  return (
    <Routes>

      {/* Register page */}
      <Route path="/" element={<Register />} />

      {/* Login page */}
      <Route path="/login" element={<Login />} />

      {/* Protected profile page */}
      <Route path="/profile"
        element={<ProtectedRoute>
          <Profile />
        </ProtectedRoute>} />

    </Routes>
  );
}

export default App;
