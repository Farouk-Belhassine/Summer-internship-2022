export class Procedure {
    id : any;
    name : any;
    sequences!: Sequence[];
}

export class Sequence{
    id : any;
    number : any;
    stages! : Stage[];
}

export class Stage{
    id : any;
    number : any;
    steps! : Step[];
}

export class Step{
    id : any;
    number : any;
    description : any;
    comment : any;
}