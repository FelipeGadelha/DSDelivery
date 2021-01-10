import React from 'react';
import { ToastContainer } from 'react-toastify';
import Routes from './Routes';

import 'react-toastify/dist/ReactToastify.css';
import './global.css';

function App() {
  return (
    <>
      <Routes />
      <ToastContainer />
    </>
  );
}

export default App;
