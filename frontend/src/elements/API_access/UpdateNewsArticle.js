import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const UpdateNewsArticle = (loggedUser) => {
    const [gameId, setGameId] = useState();
    const [image, setImage] = useState();
    const [title, setTitle] = useState();
    const [text, setText] = useState();
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
                let {text, title, image, gameId} = response.data;
                setTitle(title);
                setImage(image);
                setText(text);
                setGameId(gameId);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    const onChangeText = event => {
        setText(event.target.value);
    }
    const onChangeImage = event => {
        var reader = new FileReader();
        reader.onload = function (event) {
            setImage(event.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    const onChangeTitle = event => {
        setTitle(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        /*const config = {
            headers: { Authorization: `Bearer ${token}` }
        };*/
        const bodyParams = {
            "id": id,
            "gameId": gameId,
            "image": image,
            "text": text,
            "title": title,
        };
        axios.put(
            `http://localhost:8080/news`,
            bodyParams,
            //config
        )
            .then(function (response) {
                /*let mealName = response.data.mealName;
                navigate(`/successfullyUpdatedMeal/${mealName}`);*/
                alert('News article successfully updated!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }


    return (
        <>
            <center>
                <form onSubmit={handleSubmit}>
                    <br/><br/>
                    <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
                    <input type="file" name="image" onChange={onChangeImage} className="Label"/><br/><br/>
                    <label htmlFor="name" className="formLabelName">Title</label><br/>
                    <input type="text" name="title" onChange={onChangeTitle} value={title} className="Label" /><br/><br/>
                    <label htmlFor="text" className="formLabelText">Text</label><br/>
                    <textarea type="text" name="text" onChange={onChangeText} value={text} className="Label" /><br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}

export default UpdateNewsArticle;