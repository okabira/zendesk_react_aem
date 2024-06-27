import CustomButton from './components/button/ts/button';
import HelloWorld from './components/helloworld/ts/helloworld';
import Teaser from './components/teaser/ts/teaser';

const Mapper = {
    'wknd/components/helloworld': HelloWorld,
    'wknd/components/teaser': Teaser,
    'wknd/components/button': CustomButton,
}

export default Mapper;