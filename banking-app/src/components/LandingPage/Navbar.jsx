const Navbar = () => {
    return (
        <nav>
            <div className="navbar  flex flex-row justify-between mx-auto items-center h-[15vh] bg-gray-300 mx-auto px-[7rem]">
                <img
                    src="https://github.com/anshulghogre4/online-banking-springboot-react/blob/main/client/src/assets/images/cblogo.png?raw=true"
                    className="w-full h-full object-cover"
                    alt="banking hero"
                />
            </div>


            <div>
                <a
                    className="abc hover:bg-slate-300/[0.1] py-[0.2rem] px-[1.0rem] rounded-lg duration-[0.5s]  transition-all font-semibold"
                    href="https://github.com/drivetech16/banking-app"
                    target="_blank"
                >
                    Github
                </a>
            </div>

            <div>
                <a
                    href="#"
                    className="abc hover:bg-slate-300/[0.1] py-[0.2rem] px-[1.0rem] rounded-lg duration-[0.5s]  transition-all font-semibold"
                >
                    Contact Us
                </a>
            </div>

        </nav>
    )
}

export default Navbar