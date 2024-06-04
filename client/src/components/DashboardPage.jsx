import React, { useEffect, useState } from 'react';
import Sidebar from './dashboard/Sidebar';
import { useLocation } from "react-router-dom";
import jwt_decode from 'jwt-decode';
import DashboardNavigation from './DashboardNavigation';

export default function Dashboard() {
  const auth = useLocation();
  const [selectedButton, setSelectedButton] = useState(0);
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    let data = jwt_decode(auth.state.credential);

    fetch(`https://api.sistemaacademico.live/students/email/${data.email}`, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(json => {
        setUserData(json)
      })
      .catch(error => {
        setUserData({
          name: data.name,
          avatar_url: data.picture,
          preview: true
        })

        console.log("Preview mode has been activated")
      });
  }, []);

  return (
    userData && <div className='w-screen h-screen bg-[#F9F9F9] flex flex-row'>
      <div>
        <Sidebar userData={userData} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />
      </div>
      <div className='overflow-hidden'>
        <DashboardNavigation userData={userData} selectedButton={selectedButton} />
      </div>
    </div>
  );
}