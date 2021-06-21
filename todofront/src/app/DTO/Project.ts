export class Project
{
  public id: number | null = null;
  public name: string;
  public description: string;
  constructor(name: string, description: string)
  {
    this.name = name;
    this.description = description;
  }
}
