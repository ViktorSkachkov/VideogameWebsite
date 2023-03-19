import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie";


const ViewNewsArticle = (loggedUser) => {
    const [newsArticle, setNewsArticle] = useState(null);
    let params = useParams();
    const id = params.id;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getNewsArticle();
    }, []);
    const getNewsArticle = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/news/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setNewsArticle(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    return (
        <>
            {newsArticle != null ?
                <div className="viewGameBody">
                    <center>
                        <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
                        <h1>{newsArticle.title}</h1>
                        <p>{newsArticle.text}</p>
                    </center>
                </div> :
                <p>Loading...</p>}
        </>
    )
}
export default ViewNewsArticle;