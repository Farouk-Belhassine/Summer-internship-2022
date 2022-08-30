export class ExeProcedure {
    id : any;
    name : any;
    sequences!: ExeSequence[];
}

export class ExeSequence{
    id : any;
    number : any;
    stages! : ExeStage[];
}

export class ExeStage{
    id : any;
    number : any;
    steps! : ExeStep[];
}

export class ExeStep{
    id : any;
    number : any;
    description : any;
    comment : any;
}
