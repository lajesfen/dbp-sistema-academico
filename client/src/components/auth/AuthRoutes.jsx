import React, { useState, useEffect } from 'react';
import { Navigate, Outlet, useLocation } from "react-router-dom";

export function OauthSignin() {
  const auth = useLocation();
  console.log('Successfully Signed In', auth.state);

  return (
    <>
      <Navigate to="/dashboard" state={auth.state} />
    </>
  );
}

export function OauthLogout() {
  console.log('Successfully Signed Out, returning to login');

  return (
    <>
      <Navigate to="/login" />
    </>
  );
}

const AuthRoutes = () => {
  const auth = useLocation();
  const [userCredential, setUserCredential] = useState(auth.state?.credential);

  useEffect(() => {
    setUserCredential(auth.state?.credential);
  }, [auth.state]);

  if (!userCredential) {
    console.log('User is not Signed-In, returning to Login');
    return <Navigate to="/login" />;
  }

  return userCredential ? <Outlet /> : <Navigate to="/login" />;
};

export default AuthRoutes;