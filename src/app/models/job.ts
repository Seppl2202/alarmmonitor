export class Job {
private _description: string;
private _createDate: string;
private _jobType: string;
private _alarmedUnits: string[];
private _reporter: string;
private _adress: string;
private _uuid: string;
private _running: boolean;


  constructor(description: string, createDate: string, jobType: string, alarmedUnits: string[], reporter: string, adress: string, uuid: string, running: boolean) {
    this._description = description;
    this._createDate = createDate;
    this._jobType = jobType;
    this._alarmedUnits = alarmedUnits;
    this._reporter = reporter;
    this._adress = adress;
    this._uuid = uuid;
    this._running = false;
  }


  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get createDate(): string {
    return this._createDate;
  }

  set createDate(value: string) {
    this._createDate = value;
  }

  get jobType(): string {
    return this._jobType;
  }

  set jobType(value: string) {
    this._jobType = value;
  }

  get alarmedUnits(): string[] {
    return this._alarmedUnits;
  }

  set alarmedUnits(value: string[]) {
    this._alarmedUnits = value;
  }

  get reporter(): string {
    return this._reporter;
  }

  set reporter(value: string) {
    this._reporter = value;
  }

  get adress(): string {
    return this._adress;
  }

  set adress(value: string) {
    this._adress = value;
  }

  get uuid(): string {
    return this._uuid;
  }

  set uuid(value: string) {
    this._uuid = value;
  }


  public get running(): boolean {
    return this._running;
  }

 public set running(value: boolean) {
    this._running = value;
  }
}
