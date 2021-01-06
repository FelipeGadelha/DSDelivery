import React from 'react';
import { ReactComponent as MainImage } from '../../assets/home-image.svg';
import Footer from '../../components/Footer';


import './styles.css';
// import { Container } from './styles';

const Home: React.FC = () => {
  return (
      <>
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <h1 className="home-title">
                        Faça seu pedido 
                        <br/>que entregamos 
                        <br/>pra você!!!
                    </h1>
                    <h3 className="home-subtitle">
                        Escolha o seu pedido e em poucos minutos 
                        <br/>levaremos na sua porta
                    </h3>
                    <a href="orders" className="home-btn-order">
                        FAZER PEDIDO
                    </a>
                </div>
                <div className="home-image">
                        <MainImage />
                </div>
            </div>
        </div>
        <Footer/>
    </>
  );
}

export default Home;