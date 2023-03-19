import {useEffect, useState} from "react";
import axios from "axios";
import VideogameCard from "./VideogameCard";
import '../css/Home.css';
import {Link, useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";
import HomeDisplay from "../display/HomeDisplay";

const Home = (updateUser) => {
    let navigate = useNavigate();
    const [featuredVideogames, setFeaturedVideogames] = useState([]);
    const [upcomingVideogames, setUpcomingVideogames] = useState([]);
    const [roles, setRoles] = useState([]);

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getRoles();
        getVideogames();
    }, []);

    const getRoles = () => {
        let token_deserialized = JSON.parse(localStorage.getItem("token"));
        if(token_deserialized != null) {
            setRoles(token_deserialized.userRoles.map(element => element.role));
        }
    }

    const getVideogames = () => {
        var config1 = {
            method: "get",
            url: `http://localhost:8080/videogames/featured`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config1)
            .then(function (response) {
                setFeaturedVideogames(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });

        var config2 = {
            method: "get",
            url: `http://localhost:8080/videogames/upcoming`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config1)
            .then(function (response) {
                setUpcomingVideogames(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

        /*return (
            <>
                <center>
                    <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
                </center>
                {roles.some(r => r == "CUSTOMER") ? <>
                    <h1 className="title">Featured Games</h1>
                    <div className="listOfGames">
                        {featuredVideogames.map((videogame) => (
                            <VideogameCard videogame={videogame} />
                        ))}
                    </div>
                    <h1 className="title">Upcoming Games</h1>
                    <div className="listOfGames">
                {upcomingVideogames.map((videogame) => (
                    <VideogameCard videogame={videogame} />
                    ))}
                    </div>
                    </> : <><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </>}
            </>
        )*/

    return (
        <HomeDisplay roles={roles} featuredVideogames={featuredVideogames} upcomingVideogames={upcomingVideogames}/>
    )
}
export default Home;