
import { Navigate } from "react-router-dom";

function ProtectedRoute({ children }) {

  // Check login token
  const token = localStorage.getItem("token");

  // Go to login if token is missing
  if (!token) {
    return <Navigate to="/login" />;
  }

  // Allow access to profile page
  return children;
}

export default ProtectedRoute;
