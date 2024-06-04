import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './LoginPage';
import DashboardPage from './DashboardPage';
import AuthRoutes, { OauthLogout, OauthSignin } from './auth/AuthRoutes';

export default function App() {
  return (
    <Router>
      <Routes>
        <Route element={<AuthRoutes />}>
          <Route path='/' element={<LoginPage />} />
          <Route path='/dashboard' element={<DashboardPage />} exact />
        </Route>
        <Route path='/login' element={<LoginPage />} />
        <Route path='/oauth/login' element={<OauthSignin />}/>
        <Route path='/oauth/logout' element={<OauthLogout />}>
        </Route>
      </Routes>
    </Router>
  );
}